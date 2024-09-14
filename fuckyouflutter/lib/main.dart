import 'dart:js_interop';

import 'package:flutter/material.dart';

// const age = 27;
// const twiceTheAge = age * 2;

//varialbe => that change

//함수 복잡하면 중괄호 써서 return하는게 맞는데. 만약 단순하다면 => 형식도 쓸 수 있다
//어떤 문법을 쓸지는 팀 프로젝트 내에서의 약속으로 정할수도
// String getFullName(String firstName, String lastName) =>
//   '$firstName $lastName';  //$표시하면 따옴표 안에 있어도 변수로 인식하는듯



// void test() {
//   const name = 'Foo';
//   if (name == 'Foo') {
//     print('Yes this is foo');
//   } else if (name != 'Bar'){
//     print('this is not Bar');
//   } else {
//     print("I don't know what this is");
//   }
// }



void main() {
  // var name = 'Alex'; //final & const what's difference?
  // name = 'Anthony';
  runApp(const MyApp());
}
// void test() {
//   var names = ['Foo', 'Bar', 'Baz'];
//   print(names.length);
//   names.add('My name');
//   print(names.length);
// }

// void test() {
//   var names = {'Foo', 'bar', 'baz',};
//   names.add('foo');
//   names.add('bar');
//   names.add('baz');
//   print(names);
// }

// void test() {
//   var person = {
//     'age' : 20,
//     'name' : 'Foo'
//   };
//   person['lastname'] = 'Baz';   //if you want to modify map -> var
//   print(person);
// }

// void test() {
//   String? name = null; //? means i have a variable that's string but it's not yet decided
//   print(name);
//   name = 'Foo';
//   print(name);
// }

// void test() {
//   int? age = null;  //int도 됩니다 nullable.
//   List<String?>? names = ['Foo', 'Bar', null];  //스트링 리스트을 가지고 있는데 리스트는 널일수 있는데, 만약 널이 아니라면 널일 수 있는 요소들을 가지고 있어.
// }

//cherry-picking non-null-values
// void test() {
//   const String? firstName = null;
//   const String? middleName = null;
//   const String? lastName = 'Baz';
//
//   const firstNonNullValue = firstName ?? middleName ?? lastName;   //cherry-picking non-null-values
//   print(firstNonNullValue);
// }

// void test (String? firstName, String? middelName, String? lastlName) {
//   String? name = firstName;
//   name ??= middelName;      // ??= => it's assigned only if variable is null
//   name ??= lastlName;
//   print(name);
// }

//old way
// void test(List<String>? names) {
//   if (names != null) {
//     final length = names.length;
//   }
// }

//flutter는 null을 약간 광적으로 따라가네 왜 이럼? => 유지보수성 위함이다?
void test(List<String>? names) {
  names?.add('Baz');
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    // print(getFullName('Foo', 'Bar'));
    test();
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // TRY THIS: Try changing the color here to a specific color (to
        // Colors.amber, perhaps?) and trigger a hot reload to see the AppBar
        // change color while the other colors stay the same.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          //
          // TRY THIS: Invoke "debug painting" (choose the "Toggle Debug Paint"
          // action in the IDE, or press "p" in the console), to see the
          // wireframe for each widget.
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}