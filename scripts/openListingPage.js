"use strict";
/*
  Open lisiting page for experiments
  */

module.exports = {
  run(context) {
    return context.runWithDriver(driver => {
      // Go to Wikipedias login URL
      return driver.get("https://auto.ru/listing/yes/").then(() => {
        return driver.getTitle();
      });
    });
  }
};
