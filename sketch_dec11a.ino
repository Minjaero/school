// 필요한 핀 정의
const int pirPin = 8;       // PIR 센서의 OUT 핀
const int motorPin = 7;     // 모터 드라이버의 제어 핀
const int greenLedPin = A1; // 초록 LED의 핀
const int redLedPin = A0;   // 빨간 LED의 핀
const int switchPin = 6;    // 스위치의 핀

bool switchState = false;   // 스위치 상태 저장

void setup() {
  Serial.begin(9600);
  pinMode(pirPin, INPUT);
  pinMode(motorPin, OUTPUT);
  pinMode(greenLedPin, OUTPUT);
  pinMode(redLedPin, OUTPUT);
  pinMode(switchPin, INPUT_PULLUP);  // 내부 풀업 사용
}

void loop() {
  int pirValue = digitalRead(pirPin);  // PIR 센서 값 읽기
  switchState = digitalRead(switchPin); // 스위치 상태 읽기

  if (pirValue == HIGH) {
    Serial.println("Motion detected!");
    digitalWrite(motorPin, LOW);    // 모터 정지
    digitalWrite(greenLedPin, LOW); // 초록 LED 끄기
    digitalWrite(redLedPin, HIGH);  // 빨간 LED 켜기

    // 스위치를 누를 때까지 대기
    while (switchState) {
      switchState = digitalRead(switchPin); // 스위치 상태 읽기
      delay(50);  // 짧은 딜레이
    }

    digitalWrite(redLedPin, LOW); // 빨간 LED 끄기
  } else {
    Serial.println("No motion");
    digitalWrite(motorPin, HIGH);   // 모터 동작
    digitalWrite(greenLedPin, HIGH); // 초록 LED 켜기
    digitalWrite(redLedPin, LOW);    // 빨간 LED 끄기
  }

  delay(500);  // 딜레이를 통해 센서 읽기 주기 조절
}
