# Project Titan #

### An educational game that implements AR (augmented reality) and a progression system. ##

# Current State

* Currently we have a base implementation of the "Student" side of the project. They are assigned an avatar to show proof of concept. There is also an Augmented Reality fragment that displays their avatar in AR. moreover, the app communicates with a server side database to display a list view of assignments.

# Checklist for graded components

* Has navigation between meultiple fragments using the `Navigation Drawer` between the main fragment, AR Fragment and Assignment Fragment.
* Returns a Json object from the back end  Samurai server.
* Uses local database with Room and Hibernate and saves data from the backend Samurai server into the local database.
* `listview` in the Assignemtn fragment that uses data fromt the back end Samurai server.
* Google Sign-in, ARcore, upload from a JAR file as consumptions of external sevices.
* Custom backgrounds on Google Sign-in, and main fragment, and custom icons.

# Purpose

* The main focus point for this project is for teachers to be able to interact, educate, and utilize this app to help their students' progression throughout the school year. Each child will be able to choose an avatar, in which they will earn equipment, items such as health potions and power-ups, which are earned through completing school assignments. After completing tasks, the teacher will be able to monitor the student's progression and their entire student roster.

* If a student is struggling or not completing tasks, the teacher can opt to allow students to complete tasks for extra credit or make-up work. The teacher would be able to have this tangible object to show to their parents during parent-teacher conferences and show off what the student has earned by completing these tasks.  

# Testing

### Android API Version and Hardware Used ###
#### Android API 27

#### Nexus 5x Emulator
* No problems encountered thus far

#### Galaxy Note 9
* No problems encountered thus far

#### Galaxy S10 API 28
* No problems encountered thus far

#### LGE LG_Q710AL (Android 8.1.0 API 27) LG Stylo 4
* Not compatible with the current ARCore Version.
* Since AR is not working the test for ARFragment Will not work

### Tests

#### ARFragment
* Opens the nav Drawer
* Opens the ar fragment

#### CompleteAssignmentsTest
* Opens the nav Drawer
* Opens the assignment fragment 
* Makes sure it is loaded

#### SignOutTest
* opens the toggle tab
* signs out

# Third Party Libraries

### Libraries
 + [Google Gson](https://github.com/google/gson)
 + [Retrofit 2](https://square.github.io/retrofit/)
 + [Facebook Stetho](https://github.com/facebook/stetho)
 + [Glide](https://github.com/bumptech/glide)
 + [Room](https://developer.android.com/topic/libraries/architecture/room)
 + [Play Services Plus](https://developers.google.com/android/guides/releases)
 + [Deep Dive Android Utilities](README.md)
 + [AR Core](https://developers.google.com/ar/reference/)
  
# External Services  
 + [Google Sign-in](https://developers.google.com/identity/sign-in/android/start-integrating)
 + [AR Core](https://developers.google.com/ar/reference/java/arcore/reference/packages)
 + [Sceneform](https://developers.google.com/ar/develop/java/sceneform/)

# Potential Improvements

### Stretch Goals(simplest to hardest)

* Connect the experience bar to the samurai server so that they match up with experience gained.
* Add "Teacher" functionality to the app.
* Create "Teacher" app that allows inserts, and modifications to assignments to allow "Student" app to complete assignments and earn rewards.
* Allow "Teacher" to assign "Student" into a group or classroom for easy assignment.
* Add more models/rewards for Augmented Reality.
* Add functionality to choose a model/reward as the profile avatar.
* Add proper lootbox rewards with random rng loot.
* Add games on "Student" side so they can interact with their avatars.

### Aesthetics

* Design a common aesthetic that is unique and clean.
* Create custom icons for the various actions in the app.

# Design & technical documentation
 + [WireFrames](TeamCapstoneProjectWireFrame.pdf)
 + [User Stories](docs/UserStories.md)
 + [ERD](docs/FrontEndForProjectTitan.pdf)
 + [DDL](docs/ddl.md)
 + [Javadoc](docs/api) 
 
# Build Instructions

+ [How to build](BuildInstructions.md)

# Using the App Instructions

+ [How to use the app](AppUserInstructions.md)


# Copyrights and Licenses

Copyright 2019 Lance Zotigh, Alex Rauenzahn, Thomas Herrera & Deep Dive Coding
Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 + [Link to the Apache License](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

# Copyright and License
+ [Discolsures](Discolsures.md)
+ [Creative Commons License](https://creativecommons.org/licenses/by/3.0/legalcode)
+ [Google Sceneform License](https://github.com/googlecodelabs/sceneform-intro/blob/master/LICENSE)
+ [ArCore Disclosure](ARDiscolsure.md)
+ [Junit4 License](https://junit.org/junit4/license.html)
+ [Gson License](https://github.com/google/gson/blob/master/LICENSE)
+ [Stetho License](https://github.com/facebook/stetho/blob/master/LICENSE)

