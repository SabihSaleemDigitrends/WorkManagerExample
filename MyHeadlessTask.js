// MyHeadlessTask.js

module.exports = async taskData => {
  // Perform background task here
  console.log('Background task started with data:', taskData);
  alert('Background task started with data:', taskData);

  // Simulate some time-consuming operation
  await new Promise(resolve => setTimeout(resolve, 5000));

  // Don't forget to call finish() to signal that the background task is done
  // This is required to avoid memory leaks
  return Promise.resolve();
};
