## What is carfolio?
Oftentimes buying a car is an incredible expense. Unfortunately, nothing mechanical lasts forever either. Therefore vehicles depreciate an extreme amount the instant they leave the dealership. Unknown factors affect a car’s value in the secondhand market.

The used car market is one of the largest secondhand consumer product markets across the world. The market for used cars continues to gain footing over their new counterparts. Many cars built within the last 10 years simply don’t require upgrading. They are largely the same as what we see being manufactured today. Depreciation is still an issue we face when buying used cars. How can we mitigate the effects of depreciation?

Carfolio is most simply described as a “complete Carfax”. The allusion to the current leader on consumer vehicle history tracking is to point out what this market is currently missing. While many industries and markets have embraced the “data revolution,” documenting the life of cars is something only really done with collectors’ vehicles. Of course, collectable cars are worth exponentially more when they have comprehensive records. This is the idea that prefaces Carfolio: comprehension when considering all of the details on a vehicle.

Vehicle sellers need a better way to track their car to retain its value. In the same breath, vehicle buyers need a more comprehensive history for the cars they purchase to ensure their reliability and security in the investment of a car. 

Carfolio wants to focus on turning all cars to the same model that collectors follow: the more meticulous you are with maintaining your vehicle and documenting its history, the more value you can retain for what was likely one of the largest purchases you have made to date.   

## Requirements
* JDK: [JDK 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
* IDE: [NetBeans 11.3](https://netbeans.apache.org/download/nb113/nb113.html)

## Building
Clone the repository locally. Open Netbeans and ensure your Java platform is set to JDK 14. Open project, navigate to where you've cloned the repo, and open the carfolio folder. Netbeans should recognize the project from here. Build and Run the application. Note that it should run on Windows and Mac, but was tested on Windows. Linux platforms currently encounter a JavaFX-related error.

## Testing Credentials 
Buyer Account - 
uname: dbuyer  password: pw

Seller Account -
uname: dseller  password: pw

Admin Account - 
uname: dstetts  password: pw

## Uses
### Creating a Listing (Portfolio)
Log in as the seller. On the landing page under Sell a Car, enter the make, model, year, style, VIN, mileage, and deisred price for the vehicle. Click "build portfolio" to create the car and add it to the database.

### Viewing Listings
Log in as the buyer or Admin. On the landing page, click "advanced search". Use the left and right arrow buttons on the bottom left to page through the listings. Click on "more details" to open the advanced view of each car.

### Posting an Offer
Continuing from the previous use, click "make offer" and enter a dollar amount. If you see the confirmation pop-up, your offer has been made. To open the message

### Viewing/Responding to an Offer
Log in as the seller. On the landing page, click "portfolios". A table will be populated with each car belonging to the current user, along with the first corresponding offer, if there is one. Click "respond to offers" to open the messaging window, and switch to the message history tab. Here you can double click on a message timestamp to view its contents.
Note that there are multiple sellers, and not all offers will be sent to dseller.
