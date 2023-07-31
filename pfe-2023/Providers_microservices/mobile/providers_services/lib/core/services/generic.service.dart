

//architecture GETX
//GetConnect facilite la création de requêtes et la récupération de données.
//Afin de communiquer avec les API , on  utilise GetConnect avec les méthodes GET/POST/PUT/DELETE/SOCKET.
//import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class GenericService extends GetConnect {
  // AppPreferenceHelper _helper = new AppPreferenceHelper();
  List<String> systemRequests = [
    '/shj-applicant/api/ws/users/notifications/new-notifications-count',
    '/shj-applicant/api/ws/users/notifications/list'
  ];
  @override
  void onInit() {
//connecting with back end
    httpClient.baseUrl = "http://10.0.2.2:8088";
    httpClient.addRequestModifier<dynamic>((request) async {
      request.headers['content-Type'] = 'application/json';
      //   request.headers['CALLER-TYPE'] = 'WEB-SERVICE';
      // String? jwt = await _helper.authToken;
      /*if (jwt != null) {
        request.headers['Authorization'] = 'Bearer ' + jwt;
      }*/

      debugPrint('====================================');
      debugPrint('SENT ${request.method} REQUEST ::: URL => [${request.url}]');
      debugPrint('====================================');

      return request;
    });
    httpClient.addResponseModifier<dynamic>((request, response) async {
      debugPrint('====================================');
      debugPrint(
          'RECEIVED RESPONSE  ${response.statusCode} :: URL => [${request.url}]');
      debugPrint(response.bodyString);

      // String? jwt = response.headers?[AppPreferences.TOKEN_HEADER];
      // bool isSystemRequest = systemRequests.any((r) => r == request.url.path);
      // if (jwt != null && isSystemRequest == false) _helper.saveAuthToken(jwt);

      // if (response.statusCode == 401) {
      //   await _helper.removeAuthToken();
      //   await _helper.saveIsLoggedIn(false);
      //   Get.offAllNamed(AppRoutes.loginForm);
      // }
      return response;
    });
  }

  Response<T>? _fetchMockData<T>(String url) {
    /* if (AppConfig.instance.mockEnabled) {
      debugPrint('################## Mock is enabled');
      dynamic filteredMockData = mockData.firstWhere(
          (mockData) => url.startsWith(mockData['url']),
          orElse: () => {'url': '', 'data': ''});
      if (filteredMockData['data'].isNotEmpty) {
        return Response<T>(
            headers: <String, String>{'x-sec-tk': 'MOCK-JWT-TOKEN'},
            statusCode: HttpStatus.ok,
            bodyString: filteredMockData['data']);
      }
    }*/
    return null;
  }

  Future<dynamic> apiCall<T>(String url,
      {Decoder<T>? decoder,
      dynamic body,
      bool isPost = true,
      bool isPut = false,
      Map<String, String>? headers,
      bool headersNeeded = false}) async {
    try {
      final response = await (isPost
              ? post(url, body, headers: headers)
              : isPut
                  ? put(url, body)
                  : get(url))
          .then((value) {
        // ApiResponse apiResponse = ApiResponse.fromJsonString(value.bodyString!);
        // if (headersNeeded && value.headers != null)
        // apiResponse.headers = value.headers!;
        return value.body;
      });
      //print(response.status!);
      return (decoder == null)
          ? response
          : (response != null ? decoder(response) : throw Error());
    } catch (e) {
      return Future.error(
          'Error while calling $url, with this error: ${e.toString()}');
    }
  }

  @override
  Future<Response<T>> get<T>(
    String url, {
    Map<String, String>? headers,
    String? contentType,
    Map<String, dynamic>? query,
    Decoder<T>? decoder,
  }) {
    // check mocks
    var mockResponse = _fetchMockData<T>(url);
    if (mockResponse != null) {
      return Future.value(mockResponse);
    }
    // else execute real call
    return super.get(
      url,
      headers: headers,
      contentType: contentType,
      query: query,
      decoder: decoder,
    );
  }

  @override
  Future<Response<T>> post<T>(
    String? url,
    dynamic body, {
    String? contentType,
    Map<String, String>? headers,
    Map<String, dynamic>? query,
    Decoder<T>? decoder,
    Progress? uploadProgress,
  }) {
    // check mocks
    var mockResponse = _fetchMockData<T>(url!);
    if (mockResponse != null) {
      return Future.value(mockResponse);
    }
    // else execute real call
    return super.post(
      url,
      body,
      headers: headers,
      contentType: contentType,
      query: query,
      decoder: decoder,
      uploadProgress: uploadProgress,
    );
  }

  @override
  Future<Response<T>> put<T>(
    String url,
    dynamic body, {
    String? contentType,
    Map<String, String>? headers,
    Map<String, dynamic>? query,
    Decoder<T>? decoder,
    Progress? uploadProgress,
  }) {
    // check mocks
    var mockResponse = _fetchMockData<T>(url);
    if (mockResponse != null) {
      return Future.value(mockResponse);
    }
    // else execute real call
    return super.put(
      url,
      body,
      headers: headers,
      contentType: contentType,
      query: query,
      decoder: decoder,
      uploadProgress: uploadProgress,
    );
  }

  @override
  Future<Response<T>> patch<T>(
    String url,
    dynamic body, {
    String? contentType,
    Map<String, String>? headers,
    Map<String, dynamic>? query,
    Decoder<T>? decoder,
    Progress? uploadProgress,
  }) {
    // check mocks
    var mockResponse = _fetchMockData<T>(url);
    if (mockResponse != null) {
      return Future.value(mockResponse);
    }
    // else execute real call
    return super.patch(
      url,
      body,
      contentType: contentType,
      query: query,
      decoder: decoder,
      uploadProgress: uploadProgress,
    );
  }

  @override
  Future<Response<T>> delete<T>(
    String url, {
    Map<String, String>? headers,
    String? contentType,
    Map<String, dynamic>? query,
    Decoder<T>? decoder,
  }) {
    // check mocks
    var mockResponse = _fetchMockData<T>(url);
    if (mockResponse != null) {
      return Future.value(mockResponse);
    }
    // else execute real call
    return super.delete(
      url,
      headers: headers,
      contentType: contentType,
      query: query,
      decoder: decoder,
    );
  }
}
