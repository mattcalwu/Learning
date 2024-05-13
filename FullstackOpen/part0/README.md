# README.md

## Notes

### Fundamentals of Web Apps

Examining this page: https://studies.cs.helsinki.fi/exampleapp/

First rule of web development: Always keep the Developer Console open.

`fn - f12` or `option-cmd-i`

In the network tab, there are options to disable caching, and hiding extension
URLs.

#### HTTP Get

The server and web browser communicate using HTTP protocol. 

When you refresh the page, two things happen:

- The browser has fetched the contents of the page from server
- And has downloaded the image kuva.png 

Network > Headers (After clicking on the first item in the list)

General shows how the browser interacted with the server: 
- Get request to URL and status of request

Response Headers show us:
- Content-length which is the size of the response in bytes
- Content-type shows us that it's a text files in UTF-8 and formatted with html 

Response tab, shows us the response data, which is a regular HTML page. 
- In the tab, we see that three is a img tag that causes the browser to fetch
  the image from the server. 

The chain of events:

Browser :: GET https://studies.cs.helsinki.fi/exampleapp/
Server  :: Returns html doc
Browser :: GET https://studies.cs.helsinki.fi/exampleapp/kuva.png
Server  :: the png pic

HTML page renders first before the image is fetched.

#### Traditional web applications

Traditional web apps are where browsers fetch html documents from a server.

Server also has to form the document somehow, either statically generated or
dynamically. For this example it's dynamic as it has information on the number
of notes.

Old-school PHP programmers used to write HTML in the code. 

Other notes on traditional web apps:
- Browsers are "dumb", all the html data is from the server; app logic is on the
  server
- Can create servers with Java Spring, Python Flask, or Ruby on Rails

#### Running the app logic in the Browser




























