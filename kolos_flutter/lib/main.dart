import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:kolos_flutter/screen/choice.dart';
import 'package:kolos_flutter/screen/favorites.dart';
import 'package:kolos_flutter/screen/homepage.dart';
import 'package:kolos_flutter/screen/login.dart';
import 'package:kolos_flutter/screen/register.dart';
import 'package:kolos_flutter/screen/search.dart';
import 'package:kolos_flutter/screen/settings.dart';
import 'package:kolos_flutter/screen/statistics.dart';

void main() {
  runApp(const MyApp());
}

final GoRouter _router = GoRouter(
  initialLocation: '/',
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffoldWithoutAppBar(child: Choice());
      },
    ),
    GoRoute(
      path: '/login',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffoldWithoutAppBar(child: Login());
      },
    ),
    GoRoute(
      path: '/register',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffoldWithoutAppBar(child: Register());
      },
    ),
    GoRoute(
      path: '/settings',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Settings());
      },
    ),
    GoRoute(
      path: '/homepage',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Homepage());
      },
    ),
    GoRoute(
      path: '/search',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Search());
      },
    ),
    GoRoute(
      path: '/statistics',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Statistics());
      },
    ),
    GoRoute(
      path: '/favorites',
      builder: (BuildContext context, GoRouterState state) {
        return const MyScaffold(title: "Kolos", child: Favorites());
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
        textTheme: TextTheme(
          titleLarge: GoogleFonts.ruda(
              textStyle: const TextStyle(
                  color: textDark, fontWeight: FontWeight.w700, fontSize: 44)),
          titleMedium: const TextStyle(
              color: textDark, fontWeight: FontWeight.w500, fontSize: 32),
          titleSmall: const TextStyle(
              color: textDark, fontWeight: FontWeight.w500, fontSize: 26),
          displayLarge: const TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 44),
          displayMedium: const TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 32),
          displaySmall: const TextStyle(
              color: light, fontWeight: FontWeight.w500, fontSize: 26),
          labelMedium: GoogleFonts.ruda(
              textStyle: const TextStyle(
                  color: textDark, fontWeight: FontWeight.w500, fontSize: 16)),
          labelSmall: GoogleFonts.ruda(
              textStyle: const TextStyle(
                  color: textDark, fontWeight: FontWeight.w500, fontSize: 12)),
        ),
        scaffoldBackgroundColor: light,
        useMaterial3: true,
      ),
      routerConfig: _router,
    );
  }
}

class MyScaffold extends StatefulWidget {
  final String title;
  final Widget child;

  const MyScaffold({super.key, required this.title, required this.child});

  @override
  State<MyScaffold> createState() => _MyScaffoldState();
}

class _MyScaffoldState extends State<MyScaffold> {
  int _selectedIndex = 0;

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });

    switch (index) {
      case 0:
        context.go('/homepage');
        break;
      case 1:
        context.go('/search');
        break;
      case 2:
        context.go('/statistics');
        break;
      case 3:
        context.go('/favorites');
        break;
      case 4:
        context.go('/profile');
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.onPrimary,
        title: Text(
          widget.title,
          style: GoogleFonts.ruda(fontSize: 35, fontWeight: FontWeight.w500),
        ),
        centerTitle: true,
        leading: Padding(
          padding: const EdgeInsets.all(4.0),
          child: Container(
            decoration: BoxDecoration(
              image: const DecorationImage(
                image: AssetImage('assets/logo.png'),
                fit: BoxFit.cover,
              ),
              borderRadius: BorderRadius.circular(8),
            ),
          ),
        ),
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
      body: widget.child,
      bottomNavigationBar: BottomNavigationBar(
        showSelectedLabels: false,
        showUnselectedLabels: false,
        type: BottomNavigationBarType.fixed,
        backgroundColor: Theme.of(context).colorScheme.onPrimary,
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Accueil',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.search),
            label: 'Rechercher',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.bar_chart),
            label: 'Statistique',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.favorite_border),
            label: 'Favoris',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.account_circle_outlined),
            label: 'Profile',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Theme.of(context).colorScheme.primary,
        unselectedItemColor: Theme.of(context).colorScheme.secondary,
        onTap: _onItemTapped,
      ),
    );
  }
}

class MyScaffoldWithoutAppBar extends StatelessWidget {
  final Widget child;

  const MyScaffoldWithoutAppBar({super.key, required this.child});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: child,
    );
  }
}
