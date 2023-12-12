class usermodel {
  String username = '';
  String dob = '';
  String email = '';
  String gender = '';

  usermodel(String uid, String dob, String email, String gender) {
    this.username = uid;
    this.dob = dob;
    this.email = email;
    this.gender = gender;
  }

  static usermodel fromJson(Map<String, dynamic> json) =>
      usermodel(json['username'], json['dob'], json['email'], json['gender']);

  String getusername() {
    return username;
  }

  String getemail() {
    return email;
  }
}
