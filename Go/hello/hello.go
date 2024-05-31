package main   
// Packages are used to group functions, and they're made of all the files in 
// the same dir

import "fmt"
// Imports the popular fmt package, which contains functions for formatting 
// text and printing to console.

import "rsc.io/quote"
// go mod tidy
// Go will add the quote module as a requirement & go.sum file for use in
// authenticating the module.

func main() {
  fmt.Println("Hello, World!")
  fmt.Println(quote.Go())
}


