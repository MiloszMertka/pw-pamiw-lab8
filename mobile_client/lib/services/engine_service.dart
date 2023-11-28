import 'dart:convert';

import 'package:mobile_client/constants.dart';
import 'package:mobile_client/models/engine.dart';
import 'package:http/http.dart' as http;

class EngineService {
  const EngineService();

  Future<List<Engine>> fetchEngines() async {
    final uri = Uri.parse(enginesEndpoint);
    final response = await http.get(uri);
    return enginesFromJson(response.body);
  }

  Future<void> createEngine(Engine engine) async {
    final uri = Uri.parse(enginesEndpoint);
    await http.post(uri, body: json.encode(engine.toJson()), headers: {
      'Content-Type': 'application/json',
    });
  }

  Future<void> updateEngine(int id, Engine engine) async {
    final uri = Uri.parse('$enginesEndpoint/$id');
    await http.put(uri, body: json.encode(engine.toJson()), headers: {
      'Content-Type': 'application/json',
    });
  }

  Future<void> deleteEngine(Engine engine) async {
    final uri = Uri.parse('$enginesEndpoint/${engine.id}');
    await http.delete(uri);
  }
}
