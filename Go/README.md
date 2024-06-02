# README.md

## What is Go

Golang, or Go is a very popular language used for many different purposes. The
main thing that grabbed my attention about Go was how popular it has become as a
command line tool. 

I will be learning Go to create my own CLI-tools.

### Useful commands

#### Start module:

```go
go mod init <module-name>
```

Edit module to redirect:

```go
go mod edit -replace <module>=<localFile>
```

Synchronise module (adds files that are required in code):

```go
go mod tidy
```

Running the file:

```go
go run .
```

#### Running tests:

```go
go test
go test -v
```

#### Build:

```go
go build
```

#### List:

This lists where your build directory is.

```go
go list -f '{{.Target}}'
```

#### Install:

This allows you to run the binary you build anywhere

```go
go install
```



