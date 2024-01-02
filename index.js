/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import MyHeadlessTask from './MyHeadlessTask';

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerHeadlessTask('MyHeadlessTask', () => MyHeadlessTask);
