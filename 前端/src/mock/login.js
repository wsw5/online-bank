let demoList = [{
    "code": 200,
    "msg": null,
    "data": {
      "details": {
        "remoteAddress": "0:0:0:0:0:0:0:1",
        "sessionId": "6482C029CFC8CC87A028EB88CA0F031E"
      },
      "authorities": [],
      "authenticated": false,
      "principal": "张三",
      "credentials": "123456",
      "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiLlvKDkuIkiLCJleHAiOjE1ODIzODU4MzYsImNyZWF0ZWQiOjE1ODIzNDI2MzYwNjcsImF1dGhvcml0aWVzIjpbXX0.NRH4mcI_NFd1fIGyZiIKn7b_SUXTbUHXdqE1uLP_1E-qxcQ2kH7s_p3Rvvj9SUFAyFuYWu2mPKm5-HXyDPbkxg",
      "name": "张三"
    }
  }]

export default {
'post|/in/login':  option => {
return {
  status: 200,
  message: 'success',
  data: demoList
};
}
}