import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class Homepage extends StatefulWidget {
  const Homepage({super.key});

  @override
  State<Homepage> createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Kolos")),
      body: Column(
        children: [
          const Text("Hello World"),
          FloatingActionButton(onPressed: () => context.go('/login'))
        ],
      ),
    );
  }
}