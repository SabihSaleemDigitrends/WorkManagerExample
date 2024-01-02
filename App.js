/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useEffect} from 'react';
import {
  NativeModules,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';
import BackgroundService from 'react-native-background-actions';

const App = () => {
  useEffect(() => {
    onStartBtnPress();
  }, []);

  const onStartBtnPress = async () => {
    try {
      const sleep = time =>
        new Promise(resolve =>
          setTimeout(async () => {
            return await resolve();
          }, time),
        );

      const veryIntensiveTask = async taskDataArguments => {
        // Example of an infinite loop task
        const {delay} = taskDataArguments;
        await new Promise(async resolve => {
          for (let i = 0; BackgroundService.isRunning(); i++) {
            console.log(i, 'i');
            await sleep(delay);
          }
        });
      };

      const options = {
        taskName: 'Example',
        taskTitle: 'ExampleTask title',
        taskDesc: 'ExampleTask description',
        taskIcon: {
          name: 'ic_launcher',
          type: 'mipmap',
        },
        color: '#ff00ff',
        linkingURI: 'yourSchemeHere://chat/jane', // See Deep Linking for more info
        parameters: {
          delay: 1000,
        },
      };

      await BackgroundService.start(veryIntensiveTask, options);
      await BackgroundService.updateNotification({
        taskDesc: 'New ExampleTask description',
      }); // Only Android, iOS will ignore this call
      // iOS will also run everything here in the background until .stop() is called
      await BackgroundService.stop();
    } catch (error) {
      console.error('Error in onStartBtnPress:', error);
    }
  };

  return (
    <SafeAreaView style={{flex: 1}}>
      <Text>App</Text>
    </SafeAreaView>
  );
};

export default App;
