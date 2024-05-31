package main

import(
  "fmt"
  "log"
  
  "example.com/greetings"
  // To use this class above you need to run   
  // `go mod edit -replace example.com/greetings=../greetings`
  // This is because in produciton you would publish example.com/greetings
  // module from its repository, but since it hasn't been published, you need to
  // adapt example.com/hello module
)

func main() {
  // Set properties of the predefined Logger, including
  // the log entry prefix and a flag to disable printing
  // the time, source file, and line number.
  log.SetPrefix("greetings: ")
  log.SetFlags(0)

  // A slice of names.
  names := []string{"Gladys", "Samantha", "Darrin"}

  // Request greeting messages for the names.
  messages, err := greetings.Hellos(names)
  if err != nil {
    log.Fatal(err)
  }

  // If no error was returned, print the returned 
  // map of messagespirit to the console
  fmt.Println(messages)
}

