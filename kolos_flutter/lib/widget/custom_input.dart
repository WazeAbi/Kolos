import 'package:flutter/material.dart';

class CustomInput extends StatefulWidget {
  const CustomInput(
      {super.key,
      required this.label,
      required this.controller,
      required this.isPassword});

  final String label;
  final TextEditingController controller;
  final bool isPassword;

  @override
  State<CustomInput> createState() => _CustomInputState();
}

class _CustomInputState extends State<CustomInput> {
  bool isHidden = true;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 46, vertical: 12),
      child: TextField(
        style: Theme.of(context).textTheme.labelMedium,
        obscureText: widget.isPassword ? isHidden : false,
        controller: widget.controller,
        decoration: InputDecoration(
            suffixIcon: widget.isPassword
                ? IconButton(
                    onPressed: () {
                      setState(() {
                        isHidden = !isHidden;
                      });
                    },
                    icon: Icon(
                      !isHidden ? Icons.visibility : Icons.visibility_off,
                      color: Theme.of(context).colorScheme.secondary,
                    ),
                  )
                : null,
            enabledBorder: getStyle(),
            focusedBorder: getStyle(),
            labelText: widget.label,
            labelStyle: Theme.of(context).textTheme.labelMedium),
      ),
    );
  }

  OutlineInputBorder getStyle() {
    return OutlineInputBorder(
        borderSide: BorderSide(color: Theme.of(context).colorScheme.secondary));
  }
}
