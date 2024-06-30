import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
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
              label: "Nom",
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
            CustomElevatedButton(
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
                          context.go('/cgu');
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

  void validateForm() {}
}
