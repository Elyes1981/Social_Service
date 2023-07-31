import 'dart:convert';

class ApiResponse {
  ApiResponse({this.status, this.body, this.errors, this.headers});

  dynamic status;
  dynamic body;
  dynamic errors;
  dynamic headers;

  factory ApiResponse.fromJson(Map<String, dynamic> json) => ApiResponse(
        status: json['status'],
        body: json['body'],
        errors: json['errors'],
      );

  factory ApiResponse.fromJsonString(String jsonStr) =>
      ApiResponse.fromJson(json.decode(jsonStr));

  Map<String, dynamic> toJson() => {
        'status': status,
        'body': body,
        'errors': errors,
      };

}
