import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'firebase_options.dart';

// Initialize an instance of Firestore
final FirebaseFirestore firestore = FirebaseFirestore.instance;

Future<void> main() async {
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: TaskListScreen(),
    );
  }
}

class TaskListScreen extends StatefulWidget {
  @override
  _TaskListScreenState createState() => _TaskListScreenState();
}

class _TaskListScreenState extends State<TaskListScreen> {
  final taskController = TextEditingController();

  Future<List<QueryDocumentSnapshot>> fetchTasks() async {
    final QuerySnapshot snapshot = await firestore.collection('tasks').get();
    return snapshot.docs;
  }

  void addTask() {
    firestore.collection('tasks').add({
      'task': taskController.text,
      'isChecked': false,
      'subtasks': [],
    });
    taskController.clear();
    setState(() {});
  }

  void updateTask(String taskId, String newTask, bool newIsChecked,
      List<dynamic> newSubtasks) {
    firestore.collection('tasks').doc(taskId).update({
      'task': newTask,
      'isChecked': newIsChecked,
      'subtasks': newSubtasks.cast<String>(),
    });
  }

  void deleteTask(String taskId) {
    firestore.collection('tasks').doc(taskId).delete();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Task List'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: taskController,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                labelText: 'Enter your task',
                suffix: ElevatedButton(
                  onPressed: addTask,
                  child: Text('Add Task'),
                ),
              ),
            ),
          ),
          Expanded(
            child: FutureBuilder(
              future: fetchTasks(),
              builder: (BuildContext context,
                  AsyncSnapshot<List<QueryDocumentSnapshot>> snapshot) {
                if (snapshot.hasData) {
                  return ListView.builder(
                    itemCount: snapshot.data!.length,
                    itemBuilder: (BuildContext context, int index) {
                      final doc = snapshot.data![index];
                      return ListTile(
                        leading: Checkbox(
                          value: doc['isChecked'],
                          onChanged: (bool? value) {
                            setState(() {
                              updateTask(
                                  doc.id, doc['task'], value!, doc['subtasks']);
                            });
                          },
                        ),
                        title: Text(doc['task']),
                        trailing: IconButton(
                          icon: Icon(Icons.delete),
                          onPressed: () {
                            deleteTask(doc.id);
                            setState(() {});
                          },
                        ),
                      );
                    },
                  );
                } else if (snapshot.hasError) {
                  return Text('Error: ${snapshot.error}');
                }
                return CircularProgressIndicator();
              },
            ),
          ),
        ],
      ),
    );
  }
}
