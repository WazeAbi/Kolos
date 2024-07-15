import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:go_router/go_router.dart';
import 'package:kolos_flutter/service/user_service.dart';

class Homepage extends StatefulWidget {
  const Homepage({super.key});

  @override
  State<Homepage> createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  final FlutterSecureStorage storage = const FlutterSecureStorage();

  @override
  Widget build(BuildContext context) {
    checkLogged();
    return SingleChildScrollView(
        child: Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Center(
            child: Text(
              "Bienvenue dans l'Odyssée de Kolos :\nForgez Votre Légende",
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          const SizedBox(height: 20),
          const Text(
            "Avec Kolos, chaque utilisateur est un athlète en quête de sa propre odyssée. Enregistrez vos séances d'entraînement, suivez vos progrès et défiez les limites de votre corps et de votre esprit.",
            style: TextStyle(fontSize: 16),
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: 20),
          GridView.builder(
            shrinkWrap: true,
            physics: const NeverScrollableScrollPhysics(),
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              childAspectRatio: 1,
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
            ),
            itemCount: 6,
            itemBuilder: (context, index) {
              return Container(
                decoration: BoxDecoration(
                  image: const DecorationImage(
                    image: AssetImage('assets/logo.png'),
                    fit: BoxFit.cover,
                  ),
                  borderRadius: BorderRadius.circular(8),
                ),
              );
            },
          ),
        ],
      ),
    ));
  }

  void checkLogged() async {
    String? token;
    bool valid = false;
    if (await storage.containsKey(key: "authToken")) {
      token = await storage.read(key: "authToken");
      valid = await UserService.checkValidity(token!);
    }

    if (!mounted) return;

    if (token == null) {
      context.go('/');
    } else {
      if (valid == true) {
        return;
      } else {
        context.go('/');
      }
    }
  }
}
