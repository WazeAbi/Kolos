import 'package:flutter/material.dart';
import 'package:kolos_flutter/widget/custom_elevated_button.dart';
import 'package:kolos_flutter/widget/custom_painter.dart';

class Choice extends StatefulWidget {
  const Choice({super.key});

  @override
  State<Choice> createState() => _ChoiceState();
}

class _ChoiceState extends State<Choice> {
  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        CustomPaint(
          size: MediaQuery.of(context).size,
          painter: DiagonalPainter(),
        ),
        Center(
          child: Container(
            color: Colors.transparent, // Rendre le container transparent
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Spacer(),
                Text('Kolos', style: Theme.of(context).textTheme.titleLarge),
                const SizedBox(height: 100),
                Container(
                  width: MediaQuery.of(context).size.width * 0.4,
                  height: MediaQuery.of(context).size.width * 0.4,
                  decoration: const BoxDecoration(
                    color: Color(0xffD9C694),
                    shape: BoxShape.circle,
                    image: DecorationImage(
                      image: AssetImage('../assets/logo.png'),
                      fit: BoxFit.cover,
                    ),
                  ),
                ),
                const Spacer(),
                CustomElevatedButton(
                  text: "Connexion",
                  callback: goToLogin,
                  isDark: false,
                ),
                const SizedBox(height: 25),
                CustomElevatedButton(
                  text: "Inscription",
                  callback: goToLogin,
                  isDark: true,
                ),
                const Spacer(),
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
      ],
    );
  }

  void goToLogin() {}

  void goToRegister() {}
}
