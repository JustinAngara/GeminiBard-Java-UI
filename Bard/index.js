// works

import './node_modules/cross-fetch/dist/node-polyfill.js';
import Gemini from "gemini-ai";

const gemini = new Gemini(`/*enter api key*/`);

let sentence =` 
Prompt: Hello! 
`
  

console.log(
	await gemini.ask(sentence, {
		temperature: 0.5,
		topP: 1,
		topK: 10,
	})
);


