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

Data for page stored at this address: https://studies.cs.helsinki.fi/exampleapp/data.json

In the network tab, if you refresh the page, you will see the requests and all
the types of the requests. Notes is of the type document.

The page shown on the browser and html retrieved from notes response don't
match. This is because the head section of the HTML contains a script tag. 

After fetching the script tag, the browser begins to execute the code.

#### Event Handlers and Callback functions

```
var xhttp = new XMLHttpRequest()

// Why is the logic to handle the request here?
xhttp.onreadystatechange = function() {
  // code that takes care of the server response
}

// Why is the request at the end of the file?
xhttp.open('GET', '/data.json', true)
xhttp.send()

```

`xhttp.onreadystatechange = function()`

This is an event handler for the xhttp object. 

When the state of the object changes, the browser calls the event handler
function. 

Event handler functions are called callback functions. The runtime environment -
the browser, invokes the function at an appropriate time when the event has
occurred.

#### Document Object Model, or DOM

HTML pages can be thought of as implicit tree structures.

Document Object Model (DOM) is an Application Programming Interface (API) that
enables programmatic modification on the element trees corresponding to web
pages.

#### Manipulating the DOM from console

In Console:


```
document

list = document.getElementsByTagName('ul')[0]

newElement = document.createElement('li')
newElement.textContent = 'Page manipulation from console is easy'

list.appendChild(newElement)
```

#### CSS

Cascading Style Sheets, is a style sheet language used to determine the
appearances of web pages.

The head element of the HTML code of the Notes page contains a link tag that
determines that the browser must fetch a CSS style sheet.

``` CSS
.container {
  padding: 10px;
  border: 1px solid;
}

.notes {
  color: blue;
}
```

This class defines two selectors. They select certain parts of the page to
define styling rules to style them.

Class selectors always start with a period and contain the name of the class.

Classes are attributes, which can be added to the HTML attributes.

This can be examined on the elements tab of the console. Also can be used to
edit the CSS.


#### Loading a page containing Javascript - review 

























