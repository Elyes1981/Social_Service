
class LangageModel {
  LangageModel({
    this.idLangageSpeaking,
    this.label,
    this.label_fr,
    this.label_ar,
    this.code
  });

  int? idLangageSpeaking;
  String? label;
  String? label_fr;
  String? label_ar;
  String? code;

  factory LangageModel.fromJson(Map<String, dynamic> json) =>
      LangageModel(
        idLangageSpeaking: json["idLangageSpeaking"],
        label_fr: json["label_fr"] ?? '',
        label: json["label"] ?? '',
        label_ar: json["label_ar"],
        code: json["code"],
      );
  Map<String, dynamic> toJson() =>
      {
        "idLangageSpeaking": idLangageSpeaking,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
        "code":code
      };

}