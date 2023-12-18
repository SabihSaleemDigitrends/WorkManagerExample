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

const App = () => {
  const {BackgroundWorkManager} = NativeModules;

  useEffect(() => {
    onStartBtnPress();

    return () => {
      onCancelBtnPress();
    };
  }, []);

  const onStartBtnPress = async () => {
    BackgroundWorkManager.startBackgroundWork();
  };

  const onCancelBtnPress = async () => {
    BackgroundWorkManager.stopBackgroundWork();
  };

  return (
    <SafeAreaView>
      <View></View>
    </SafeAreaView>
  );
};

export default App;
