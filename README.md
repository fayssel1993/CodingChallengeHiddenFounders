# Coding Challenge Hidden Founders
## Idea of the App
A small app that list the most starred Github repos that were created in the last 30 days.
# Features
* The User can list the most starred Github repos that were created in the last 30 days.
* The User can see the results as a list. One repository per row.
* The User can see for each repo/row the following details :
  - Repository name
  - Repository description
  - Numbers of stars for the repo.
  - Username and avatar of the owner.
* The User can see new results when scrolling(Pagination with recyclerView).
# Libraries
In this app i use a lot of libraries that i was used to :
### Retrofit2 :+1:
* Type-safe HTTP client for Android and Java by Square, Inc.
* For more information please see [Retrofit2 Docs](https://square.github.io/retrofit/)
#### gradle
To use Retrofit2 you can add this line in your gradle file (module App).
```
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
```
### Dagger2 
* A fast dependency injector for Android and Java.
* For more information please see [Dagger 2](https://google.github.io/dagger/)
#### gradle
To use Dagger2 you can add this line in your gradle file (module App).
```
annotationProcessor "com.google.dagger:dagger-compiler:$daggerVersion"
implementation "com.google.dagger:dagger:$daggerVersion"
```
### RxJava 
* Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.
* For more information please see [reactivex](http://reactivex.io/)
#### gradle
To use RxJava you can add this line in your gradle file (module App).
```
implementation "io.reactivex:rxjava:$rxjavaVersion"
```
### Glide 
* Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
* For more information please see [Glide-setup](http://bumptech.github.io/glide/doc/download-setup.html)
#### gradle
To use Glide you can add this line in your gradle file (module App).
```
implementation "com.github.bumptech.glide:glide:$glideVersion"
annotationProcessor "com.github.bumptech.glide:compiler:$glideVersion"
```
# GitHub Api

For more informations about the GitHup Api you can visit the [official documentation](https://developer.github.com/v3/?) 
