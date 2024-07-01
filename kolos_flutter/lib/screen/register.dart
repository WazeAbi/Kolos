import 'dart:convert';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;
import 'package:kolos_flutter/widget/custom_back_button.dart';
import 'package:kolos_flutter/widget/custom_elevated_button.dart';
import 'package:kolos_flutter/widget/custom_input.dart';

class Register extends StatefulWidget {
  const Register({super.key});

  @override
  State<Register> createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _emailConfirmController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _passwordConfirmController =
      TextEditingController();
  bool cguChecked = false;
  bool isLoading = false;

  final _emailRegex = RegExp(r'^[^@]+@[^@]+\.[^@]+$');
  final _passwordRegex =
      RegExp(r'^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$');

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 0),
        child: Column(
          children: [
            const CustomBackButton(),
            Text(
              'Inscription',
              style: Theme.of(context).textTheme.titleLarge,
            ),
            const SizedBox(
              height: 15,
            ),
            CustomInput(
              label: "Nom d'utilisateur",
              controller: _usernameController,
              isPassword: false,
            ),
            CustomInput(
              label: "Email",
              controller: _emailController,
              isPassword: false,
            ),
            CustomInput(
              label: "Confirmation Email",
              controller: _emailConfirmController,
              isPassword: false,
            ),
            CustomInput(
                label: "Mot de passe",
                controller: _passwordController,
                isPassword: true),
            CustomInput(
                label: "Confirmation Mot de passe",
                controller: _passwordConfirmController,
                isPassword: true),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Checkbox(
                    activeColor: Theme.of(context).colorScheme.secondary,
                    value: cguChecked,
                    onChanged: ((value) {
                      setState(() {
                        cguChecked = value!;
                      });
                    })),
                RichText(
                  text: TextSpan(
                    style: Theme.of(context).textTheme.bodyMedium,
                    children: <TextSpan>[
                      TextSpan(
                          text: "J'accepte les ",
                          style: Theme.of(context)
                              .textTheme
                              .labelMedium
                              ?.copyWith(fontSize: 14)),
                      TextSpan(
                          text: "conditions générales d'utilisations",
                          style: Theme.of(context)
                              .textTheme
                              .labelMedium
                              ?.copyWith(
                                  fontWeight: FontWeight.bold, fontSize: 14),
                          recognizer: TapGestureRecognizer()
                            ..onTap = () {
                              context.go('/cgu');
                            })
                    ],
                  ),
                ),
              ],
            ),
            const SizedBox(height: 20),
            isLoading
                ? CircularProgressIndicator(
                    color: Theme.of(context).colorScheme.onSecondary,
                  )
                : CustomElevatedButton(
                    text: "Inscription",
                    callback: validateForm,
                    isDark: true,
                  ),
            const SizedBox(height: 60),
            RichText(
              text: TextSpan(
                style: Theme.of(context).textTheme.bodyMedium,
                children: <TextSpan>[
                  TextSpan(
                      text: "Deja un compte? ",
                      style: Theme.of(context).textTheme.labelSmall),
                  TextSpan(
                      text: "Connexion",
                      style: Theme.of(context).textTheme.labelSmall?.copyWith(
                            fontWeight: FontWeight.w900,
                          ),
                      recognizer: TapGestureRecognizer()
                        ..onTap = () {
                          context.go('/login');
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
    );
  }

  void validateForm() async {
    final String username = _usernameController.text;
    final String email = _emailController.text;
    final String emailConfirm = _emailConfirmController.text;
    final String password = _passwordController.text;
    final String passwordConfirm = _passwordConfirmController.text;

    if (username.isEmpty) {
      ScaffoldMessenger.of(context)
          .showSnackBar(const SnackBar(content: Text('Le nom est requis.')));
      return;
    }

    if (!cguChecked) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
          content: Text('Vous devez accepter les CGU pour continuer.')));
      return;
    }

    if (email != emailConfirm) {
      ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text('Les emails ne correspondent pas.')));
      return;
    }

    if (!_emailRegex.hasMatch(email)) {
      ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text('Adresse email invalide.')));
      return;
    }

    if (password != passwordConfirm) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
          content: Text('Les mots de passe ne correspondent pas.')));
      return;
    }

    if (!_passwordRegex.hasMatch(password)) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
          content: Text(
              'Le mot de passe doit contenir au moins 8 caractères, dont une majuscule, une minuscule, un chiffre et un caractère spécial.')));
      return;
    }

    setState(() {
      isLoading = true;
    });

    final Map<String, dynamic> body = {
      "username": username,
      "email": email,
      "password": password,
      "roleUser": "USER"
    };

    try {
      final response = await http.post(
        Uri.parse('http://localhost:8080/register'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode(body),
      );

      if (!mounted) return;

      if (response.statusCode == 200) {
        ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Inscription réussie !')));
        context.go('/login'); // Rediriger vers la page de connexion
      } else if (response.statusCode == 409 &&
          response.body.contains('Email already exists')) {
        ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Cet email est déjà utilisé.')));
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Erreur lors de l\'inscription.')));
      }
    } catch (e) {
      if (!mounted) return;

      ScaffoldMessenger.of(context)
          .showSnackBar(SnackBar(content: Text('Erreur : $e')));
    } finally {
      if (mounted) {
        setState(() {
          isLoading = false;
        });
      }
    }
  }
}
