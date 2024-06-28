import 'package:flutter/material.dart';

class ModalConfirmation extends StatelessWidget {
  final Function onConfirm;
  final String message;

  const ModalConfirmation(
      {super.key, required this.onConfirm, required this.message});

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Center(child: Text(message)),
      actions: <Widget>[
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            TextButton(
              child: Text('Annuler',
                  style: Theme.of(context).textTheme.titleSmall),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
            TextButton(
              style: ButtonStyle(
                  backgroundColor: WidgetStateProperty.all<Color>(
                      Theme.of(context).colorScheme.onSecondary),
                  padding: WidgetStateProperty.all<EdgeInsetsGeometry>(
                      const EdgeInsets.all(16))),
              child: Text('Déconnexion',
                  style: Theme.of(context).textTheme.titleSmall),
              onPressed: () {
                Navigator.of(context).pop();
                onConfirm();
              },
            ),
          ],
        )
      ],
    );
  }
}
