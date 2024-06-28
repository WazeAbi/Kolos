import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:kolos_flutter/screen/homepage.dart';
import 'package:kolos_flutter/screen/login.dart';
import 'package:kolos_flutter/screen/settings.dart';

void main() {
  runApp(const MyApp());
}

final GoRouter _router = GoRouter(
  initialLocation: '/',
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Homepage());
      },
    ),
    GoRoute(
      path: '/login',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Login());
      },
    ),
    GoRoute(
      path: '/settings',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Settings());
      },
    ),
  ],
);

const primary = Color(0xffD9C694);
const secondary = Color(0xff5B5143);
const light = Color(0xffFEFBEE);
const textDark = Color(0xff1C1C1C);

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      debugShowCheckedModeBanner: false,
      title: 'Kolos',
      theme: ThemeData(
        colorScheme: const ColorScheme.light(
          onPrimary: primary,
          onSecondary: secondary,
          primary: light,
          secondary: textDark,
        ),
        textTheme: const TextTheme(
          titleLarge: TextStyle(
              color: textDark, fontWeight: FontWeight.w500, fontSize: 44),
          titleMedium: TextStyle(
              color: textDark, fontWeight: FontWeight.w500, fontSize: 32),
          titleSmall: TextStyle(
              color: textDark, fontWeight: FontWeight.w500, fontSize: 26),
          displayLarge: TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 44),
          displayMedium: TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 32),
          displaySmall: TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 26),
        ),
        scaffoldBackgroundColor: light,
        useMaterial3: true,
      ),
      routerConfig: _router,
    );
  }
}

class MyScaffold extends StatelessWidget {
  final String title;
  final Widget child;

  const MyScaffold({super.key, required this.title, required this.child});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.onPrimary,
        title: Text(title),
        actions: [
          IconButton(
            onPressed: () {
              context.go('/settings');
            },
            icon: const Icon(
              Icons.settings_outlined,
              color: Colors.black,
            ),
          ),
        ],
      ),
      body: child,
    );
  }
}
