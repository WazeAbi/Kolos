import 'package:jwt_decoder/jwt_decoder.dart';

class UserService {
  static Future<bool> checkValidity(String token) async {
    bool isExpired = JwtDecoder.isExpired(token);

    if (isExpired) {
      return false;
    }

    return true;
  }
}
