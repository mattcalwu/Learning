# Contents

- [Content](#content)
- [README.md](#readmemd)
  - [Introduction to React](#introduction-to-react)
    - [Component](#component)
    - [JSX](#jsx)
    - [Multiple Components](#multiple-components)
    - [Props: passing data to components](#props-passing-data-to-components)
    - [Possible Error Message](#possible-error-message)
    - [Some notes](#some-notes)
    - [Do not render objects](#do-not-render-objects)
    - [Exercises 1.1-1.2](#exercises-11-12)
      - [1.1 Course Information, step 1](#11-course-information-step-1)
      - [1.2](#12)
  - [JavaScript](#javascript)

# README.md

## Introduction to React

How to make a simple React application with vite:

```
npm create vite@latest part1 -- --template react
```

How to run the application. 

```
npm run dev
```

### Component

```javascript
const App = () => {
  return (
      <div>
         <p>Hello world</p>
      </div>
 )
}
```

This is a shorthand, where the function consists of only a single expression.
The function is returning the value of the expression.

Within the function you can render dynamic content:

```javascript
const App = () => {
  const now = new Date()
  const a = 10
  const b = 20
  console.log(now, a + b);

  return (
    <div>
      <p>Hello world, it is {now.toString()}</p>
      <p>{a} plus {b} is {a + b}</p>
    </div>
  )
}
```

### JSX

JavaScript XML, looks like HTML markup, however it is not that. 

Under the hood, JSX actually is compiled into JavaScript and looks like this:

```javascript
const App = () => {
  const now = new Date()
  const a = 10
  const b = 20
  return React.createElement(
    'div',
     null,
     React.createElement(
       'p', null, 'Hello world, it is ', now.toString()
      ),
     React.createElement(
       'p', null, a, ' plus ', b, ' is ', a + b
    )
  )
}
```

This compilation is handled by Babel. Projects created with create-react-app or
vite are already preconfigured. 

The reason why it is XML, is because every tag needs to be closed. 

### Multiple Components

```javascript
const Hello = () => {
  return (
    <div>
      <p>Hello world</p>
    </div>
  )
}

const App = () => {
  return (
    <div>
      <h1>Greetings</h1>
      <Hello />
    </div>
  )
}
```

We have defined a new component Hello and used it inside the component App.
Naturally, a component can be used multiple times.

NB: `export` at the bottom allows these components to be exported. 

Core philosophy of react is composing applications from many specialized
reusable components.

Another strong convention is the idea of a root component called App at the top
of the component tree of the application. There are some situations where the
component App is not exactly the root. 

### Props: passing data to components

```javascript
const Hello = (props) => {
  return (
    <div>
      <p>Hello {props.name}</p>
    </div>
  )
}
```

This parameter props, now allows the component to recieve and object as an
argument. These are defined as below.

```javascript
const App = () => {
  return (
      <div>
        <h1>Greetings</h1>
        <Hello name='George' />
        <Hello name='Daisy' />
      </div>
  )
}
```

There can be an arbitrary number of props and their values can be "hard-coded"
strings, or JavaScript expressions. 

The props sent by the component App are the values of the variables. 

Note, at all times, your dev console should be open.

### Possible Error Message

There is an error that says: 'name' is missing in props validation.

This is not an actual error, but a warning from ESLint. You can silence the
warning react/prop-types by adding this to .eslintrc.cjs:

```javascript
module.exports = {
   root: true,
   env: { browser: true, es2020: true },
   extends: [
     'eslint:recommended',
     'plugin:react/recommended',
     'plugin:react/jsx-runtime',
     'plugin:react-hooks/recommended',
     ],
     ignorePatterns: ['dist', '.eslintrc.cjs'],
     parserOptions: { ecmaVersion: 'latest',
     sourceType: 'module' },
     settings: { react: { version: '18.2' }
     },
     plugins: ['react-refresh'],
     rules: {
     'react-refresh/only-export-components': [
       'warn',
       { allowConstantExport: true },
     ],
     'react/prop-types': 0
  },
}
```

### Some notes

React has been configured to generate quite clear error messages. Despite this,
you should, at least in the beginning, advance in very small steps.

The First letter of React component names must be capitalized. 

Also, the content of a React component (usually) needs to contain one root
element. Or an array of components works as well. There are such things as
fragments too. 

```javascript
const App = () => {
  const name = 'Peter'
  const age = 10
  
  return (
    <>
      <h1>Greetings</h1>
      <Hello name='Maya' age={26+10} />
      <Hello name={name} age={age} />
      <Footer />
    </>
    )
}
```

### Do not render objects

```javascript
const App = () => {
  const friends = [
    { name: 'Peter', age: 4 },
    { name: 'Maya', age: 10 },
  ]
  
  return (
    <div>
      <p>{friends[0]}</p>
      <p>{friends[1]}</p>
    </div>
  )
}

export default App
```

Objects are not valid as a React child. 

Individual things rendered in braces must be primitive values such as numbers or
strings. 

The fix is this:

```javascript
const App = () => {
  const friends = [
    { name: 'Peter', age: 4 },
    { name: 'Maya', age: 10 },
  ]
  
  return (
    <div>
      <p>{friends[0].name} {friends[0].age</p>
      <p>{friends[1].name} {friends[1].age</p>
    </div>
  )
}

export default App
```

Arrays can also be displayed if they contain values that React looks for. 

### Exercises 1.1-1.2

#### 1.1 Course Information, step 1

Use Vite to initialize a new application. Modify main.jsx to match:

```javascript
import ReactDOM from 'react-dom/client'

import App from './App'

ReactDOM.createRoot(document.getElementById('root')).render(<App/>)
```

App.jsx
```javascript
const App = () => {
  const course = 'Half Stack application development'
  const part1 = 'Fundamentals of React'
  const exercises1 = 10
  const part2 = 'Using props to pass data'
  const exercises2 = 7
  const part3 = 'State of a component'
  const exercises3 = 14
  
  return (
    <div>
      <h1>{course}</h1>
      <p>
        {part1} {exercises1}
      </p>
      <p>
        {part2} {exercises2}
      </p>
      <p>
        {part3} {exercises3}
      </p>
      <p>Number of exercises {exercises1 + exercises2 + exercises3}</p>
    </div>
    )
}

export default App
```      
#### 1.2

Refactor the code so that the there are even more components. Look at
CourseInfo Repo for 1.1-1.2

## JavaScript
