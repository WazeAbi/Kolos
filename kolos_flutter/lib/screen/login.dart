import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Kolos")),
      body: Column(
        children: [
          const Text("Login"),
          FloatingActionButton(onPressed: () => context.go('/test'))
        ],
      ),
    );
  }
}
