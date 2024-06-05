const Hello = (props) => {
  console.log(props)
  return (
    <div>
      <p>Hello {props.name}, you are {props.age} years old</p>
    </div>
  )
}

const App = () => {
  const age = 10
  const friends = [ 'Peter', 'Maya']

  return (
    <div>
      <h1>Greetings</h1>
      <Hello name="George" age={26+10}/>
      <Hello name="Daisy" age={age}/>
      <p>{friends}</p>
      <p>{friends[0]} {friends[1]}</p>
    </div>
  )
}

export default App
