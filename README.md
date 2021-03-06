# (Project 2) Movie App Final Project

![Latest Version](https://img.shields.io/badge/latestVersion-1.0-yellow) ![Java](https://img.shields.io/badge/language-java-blue) ![Minimum SDK Version](https://img.shields.io/badge/minSDK-21-orange)

The goal of this assignment is to learn how to use some Huawei services on Android projects. Account Kit for sign-in process, Push Kit for sending push notifications and on-device image classification capability of ML Kit will be used in the project. Also, you will learn to use Cloud Debugging for debugging your application on a remote Huawei device.

**Note: agconnect.json file and .jks file that are specific for the project have been added to .gitignore in this repo.**

## Screenshots
![Capture](https://user-images.githubusercontent.com/34041050/148967968-9a1b6430-d762-46ad-ae15-5a3a20121753.PNG)
![PushSS1](https://user-images.githubusercontent.com/34041050/148966269-a563fd80-7bd5-4cc1-932e-11b0d330dbef.PNG)
![PushSS2](https://user-images.githubusercontent.com/34041050/148966304-790d3108-31a9-4606-8d97-5c0c8b5827a8.PNG)
![image](https://user-images.githubusercontent.com/34041050/148966435-b55756a5-7e77-47d8-a6d5-8ffeb66aebe0.png)

## Used Technologies
- <a href="https://developer.android.com/jetpack/guide?gclid=EAIaIQobChMItvjx8cjo8wIVpgIGAB1e7QToEAAYASAAEgLD9fD_BwE&gclsrc=aw.ds" target="_blank">MVVM Design Pattern</a>
- <a href="https://github.com/square/retrofit" target="_blank">Retrofit-2</a>
- <a href="https://developer.android.com/topic/libraries/view-binding" target="_blank">View Binding</a>
- <a href="https://developer.android.com/guide/topics/ui/layout/recyclerview?gclid=EAIaIQobChMI3JjEh8no8wIVPIxoCR0mFAhMEAAYASAAEgK87_D_BwE&gclsrc=aw.ds" target="_blank">RecyclerView</a>
- <a href="https://developer.android.com/topic/libraries/architecture/livedata" target="_blank">LiveData</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050048870" target="_blank">HMS Account Kit</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/service-introduction-0000001050040060" target="_blank">HMS Push Kit</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/hiai-Guides/image-classification-0000001050040095" target="_blank">HMS ML Kit</a>

## The app has following packages
- adapter: It contains adapter class for RecyclerView.
- data: It contains all the data accessing and manipulating components.
- service: It contains the necessary classes for the Retrofit library.
- ui: View classes along with their corresponding ViewModel.
- utils: Utility classes.

## Clone the Repository

### With SSH
```
git clone git@github.com:BAU-COOP4423/P2-Movie-App-Final-Project.git
```

### With HTTPS
```
git clone https://github.com/BAU-COOP4423/P2-Movie-App-Final-Project.git
```

## Utilized resources
- <a href="https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#0" target="_blank">Preparation Steps of HMS Core Integration</a>
- <a href="https://medium.com/huawei-developers-tr/cloud-debug-uygulaman%C4%B1z%C4%B1-huawei-cihazlarda-test-edin-d71ec62cba11" target="_blank">Huawei Cloud Debugging Usage</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050048870" target="_blank">HMS Account Kit Official Documentation</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-scenario-id-token-0000001116078504" target="_blank">HMS Account Kit Sign-In via ID Token</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/service-introduction-0000001050040060" target="_blank">HMS Push Kit Official Documentation</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/hiai-Guides/service-introduction-0000001050040017" target="_blank">HMS ML Kit Official Documentation</a>
- <a href="https://developer.huawei.com/consumer/en/doc/development/hiai-Guides/image-classification-0000001050040095" target="_blank">HMS ML Kit Image Classification</a>


#### Note:
> Do not hesitate to open an <a href="https://github.com/BAU-COOP4423/P2-Movie-App-Final-Project/issues" target="_blank">issue</a> for your questions.
