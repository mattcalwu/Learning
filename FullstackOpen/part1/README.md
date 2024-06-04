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

```jsx
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

```jsx
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

```jsx
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


