import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:kolos_flutter/widget/modal_confirmation.dart';

class Settings extends StatefulWidget {
  const Settings({super.key});

  @override
  State<Settings> createState() => _SettingsState();
}

class _SettingsState extends State<Settings> {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: [
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(4.0),
              child: Text(
                'Paramètres du compte',
                style: Theme.of(context).textTheme.displayMedium,
              ),
            ),
          ),
          tileColor: Theme.of(context).colorScheme.onSecondary,
        ),
        GestureDetector(
          onTap: () => context.go('/'),
          child: ListTile(
            title: Center(
              child: Padding(
                padding: const EdgeInsets.all(10.0),
                child: Text(
                  'Supprimer mon compte',
                  style: Theme.of(context).textTheme.titleSmall,
                ),
              ),
            ),
          ),
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text('Options de confidentialité',
                  style: Theme.of(context).textTheme.titleSmall),
            ),
          ),
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text('Theme : Clair',
                  style: Theme.of(context).textTheme.titleSmall),
            ),
          ),
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(4.0),
              child: Text(
                "Paramètres de l'appli",
                style: Theme.of(context).textTheme.displayMedium,
              ),
            ),
          ),
          tileColor: Theme.of(context).colorScheme.onSecondary,
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text('Conditions générales',
                  style: Theme.of(context).textTheme.titleSmall),
            ),
          ),
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text('Politique de confidentialité',
                  style: Theme.of(context).textTheme.titleSmall),
            ),
          ),
        ),
        ListTile(
          title: Center(
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text('A propos',
                  style: Theme.of(context).textTheme.titleSmall),
            ),
          ),
        ),
        Padding(
          padding: EdgeInsets.symmetric(
              horizontal: MediaQuery.of(context).size.width * 0.20,
              vertical: MediaQuery.of(context).size.width * 0.05),
          child: ElevatedButton(
            style: ButtonStyle(
              elevation: WidgetStateProperty.all<double?>(5),
              backgroundColor: WidgetStatePropertyAll<Color>(
                  Theme.of(context).colorScheme.onSecondary),
              padding:
                  WidgetStateProperty.all<EdgeInsets>(const EdgeInsets.all(20)),
            ),
            onPressed: () {
              showDialog(
                context: context,
                builder: (BuildContext context) {
                  return ModalConfirmation(
                    onConfirm: () {
                      logout();
                    },
                    message: 'Êtes-vous sûr de vouloir vous déconnecter ?',
                  );
                },
              );
            },
            child: const Text(
              "Déconnexion",
              style: TextStyle(color: Colors.white, fontSize: 20),
            ),
          ),
        ),
      ],
    );
  }

  void redirect() {
    context.go('/');
  }

  void logout() {
    redirect();
  }
}
