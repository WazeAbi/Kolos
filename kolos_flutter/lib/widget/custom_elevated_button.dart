import 'package:flutter/material.dart';

class CustomElevatedButton extends StatelessWidget {
  const CustomElevatedButton(
      {super.key,
      required this.text,
      required this.callback,
      required this.isDark});

  final bool isDark;
  final String text;
  final Function callback;

  @override
  Widget build(BuildContext context) {
    ElevatedButton button;
    button = ElevatedButton(
      onPressed: () {
        callback();
      },
      style: ButtonStyle(
          elevation: WidgetStateProperty.all<double?>(5),
          backgroundColor: WidgetStatePropertyAll<Color>(isDark
              ? Theme.of(context).colorScheme.onSecondary
              : Theme.of(context).colorScheme.primary),
          fixedSize: WidgetStatePropertyAll<Size>(Size(
              MediaQuery.of(context).size.width * 0.6,
              MediaQuery.of(context).size.width * 0.09))),
      child: Text(
        text,
        style: isDark
            ? TextStyle(
                fontSize: 16,
                color: Theme.of(context).colorScheme.primary,
                fontWeight: FontWeight.w500)
            : TextStyle(
                fontSize: 16,
                color: Theme.of(context).colorScheme.secondary,
                fontWeight: FontWeight.w500),
      ),
    );
    return button;
  }
}
