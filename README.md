# Feature Service

As a code challenge I have refactored existing code and also added new endpoint.

In the first Part I did the below list

1. Restructured existing code like add some new packages
2. Add new Feature service which is in charge of all activities around features
3. Add an Interface for each class as a factory
4. crete a private method as `getAllFeatures` to increase reusability

And in the second part, I have added new field to the data class which is `quicklook`. 
This field contains the base64 encoded string as mentioned in the Email. This string must be decoded and then passed as a Media
There are two different solutions to return an image in Spring MVC. the first one using, `@Produce` or set `produces` parameter in `@GetMapping` and the second one is setting content type in `ResponseEntity` which I have chosen the second one 

Finally adding some new unit test to covers some new features. I believe test coverage must be more than but needs more time. 
