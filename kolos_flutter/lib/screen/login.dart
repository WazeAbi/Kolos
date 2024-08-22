import 'dart:convert';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:go_router/go_router.dart';
import 'package:kolos_flutter/widget/custom_back_button.dart';
import 'package:kolos_flutter/widget/custom_elevated_button.dart';
import 'package:kolos_flutter/widget/custom_input.dart';
import 'package:http/http.dart' as http;

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  bool isLoading = false;

  final _emailRegex = RegExp(r'^[^@]+@[^@]+\.[^@]+$');
  final storage = const FlutterSecureStorage();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 0),
          child: Column(
            children: [
              const SizedBox(height: 50),
              const CustomBackButton(),
              const SizedBox(height: 90),
              Container(
                width: MediaQuery.of(context).size.width * 0.4,
                height: MediaQuery.of(context).size.width * 0.4,
                decoration: const BoxDecoration(
                  color: Color(0xffD9C694),
                  shape: BoxShape.circle,
                  image: DecorationImage(
                    image: AssetImage('assets/logo.png'),
                    fit: BoxFit.cover,
                  ),
                ),
              ),
              const SizedBox(height: 50),
              Text(
                'Connexion',
                style: Theme.of(context).textTheme.titleLarge,
              ),
              const SizedBox(height: 25),
              CustomInput(
                label: "Email",
                controller: _emailController,
                isPassword: false,
              ),
              CustomInput(
                label: "Mot de passe",
                controller: _passwordController,
                isPassword: true,
              ),
              Padding(
                padding:
                    const EdgeInsets.symmetric(horizontal: 35, vertical: 0),
                child: Align(
                  alignment: Alignment.centerLeft,
                  child: TextButton(
                    onPressed: () {
                      context.go('/forgot-password');
                    },
                    child: Text(
                      'Mot de passe oublié?',
                      style: TextStyle(
                        color: Theme.of(context).colorScheme.secondary,
                      ),
                    ),
                  ),
                ),
              ),
              const SizedBox(height: 20),
              isLoading
                  ? CircularProgressIndicator(
                      color: Theme.of(context).colorScheme.onSecondary,
                    )
                  : CustomElevatedButton(
                      text: "Connexion",
                      callback: validateForm,
                      isDark: true,
                    ),
              const SizedBox(height: 60),
              RichText(
                text: TextSpan(
                  style: Theme.of(context).textTheme.bodyMedium,
                  children: <TextSpan>[
                    TextSpan(
                        text: "Pas de compte? ",
                        style: Theme.of(context).textTheme.labelSmall),
                    TextSpan(
                        text: "Créez-en un",
                        style: Theme.of(context).textTheme.labelSmall?.copyWith(
                              fontWeight: FontWeight.w900,
                            ),
                        recognizer: TapGestureRecognizer()
                          ..onTap = () {
                            context.go('/register');
                          })
                  ],
                ),
              ),
              const SizedBox(height: 60),
              Text(
                'Kolos © 2024',
                style: TextStyle(
                    fontSize: 16,
                    color: Theme.of(context).colorScheme.secondary,
                    fontWeight: FontWeight.w500),
              ),
              const SizedBox(height: 20),
            ],
          ),
        ),
      ),
    );
  }

  void validateForm() async {
    final String email = _emailController.text;
    final String password = _passwordController.text;

    if (!_emailRegex.hasMatch(email)) {
      showSnackbarMessage('Adresse email invalide.');
      return;
    }

    if (password.isEmpty) {
      showSnackbarMessage('Le mot de passe est requis.');
      return;
    }

    setState(() {
      isLoading = true;
    });

    final String basicAuth = basicAuthHeader(email, password);

    try {
      final response = await http.post(
        Uri.parse('http://localhost:8080/login'),
        headers: {
          'Content-Type': 'application/json',
          'Authorization': basicAuth,
        },
      );

      if (response.statusCode == 200) {
        final String token = response.body;
        await storage.write(key: 'authToken', value: token);

        if (mounted) {
          showSnackbarMessage('Connexion réussie !');
          context.go('/homepage');
        }
      } else if (response.statusCode == 401) {
        showSnackbarMessage('Identifiants incorrects.');
      } else {
        showSnackbarMessage('Erreur lors de la connexion.');
      }
    } catch (e) {
      if (mounted) {
        showSnackbarMessage('Erreur : $e');
      }
    } finally {
      if (mounted) {
        setState(() {
          isLoading = false;
        });
      }
    }
  }

  void showSnackbarMessage(String message) {
    if (mounted) {
      ScaffoldMessenger.of(context)
          .showSnackBar(SnackBar(content: Text(message)));
    }
  }

  String basicAuthHeader(String username, String password) {
    final String credentials = '$username:$password';
    final String encodedCredentials = base64Encode(utf8.encode(credentials));
    return 'Basic $encodedCredentials';
  }
}
