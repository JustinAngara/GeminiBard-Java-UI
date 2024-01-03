// works

import './node_modules/cross-fetch/dist/node-polyfill.js';
import Gemini from "gemini-ai";

const gemini = new Gemini('AIzaSyAwu6kKeryvX9DrFlYA9499YhuIzD6QiIw');

let sentence =` 
Prompt: Hello! null
`
  

console.log(
	await gemini.ask(sentence, {
		temperature: 0.5,
		topP: 1,
		topK: 10,
	})
);

// import './node_modules/cross-fetch/dist/node-polyfill.js';
// import fs from "fs";
// import Gemini from "gemini-ai";

// const gemini = new Gemini(`AIzaSyAwu6kKeryvX9DrFlYA9499YhuIzD6QiIw`);

// console.log(
// 	gemini.ask("What's this show?", {
// 		data: [fs.readFileSync("./please work.png")],
// 	})
// );



// import { MongoClient } from 'mongodb'
// var url = "mongodb+srv://justinangara:BYQdys8HoSgz4PfH@mydatabase.kzsr5i0.mongodb.net/";

// MongoClient.connect(url, function(err, db) {
//   if (err) throw err;
//   var dbo = db.db("bookstore");
//   //Find the first document in the customers collection:
//   dbo.collection("books").findOne({}, function(err, result) {
//     if (err) throw err;
//     console.log(result.name);
//     db.close();
//   });
// });

