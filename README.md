# JobViz Deployment and Summary 

## Executive Summary

It is time consuming for current or prospective employees to analyze government data in order to find information regarding the job market. JobViz aims to give users useful and readable data through visualizations and intuitive data querying, in order to streamline job hunting and analysis.

The application takes various inputs selected by the user and partitions the data set such that desired groupings are achieved. The extracted data is used as a basis for querying, visualization, and other aspects of the application’s interface. 

The algorithmic challenges behind the application include stable sorting, searching, and shortest graphing paths. These operations will be performed as efficiently and quickly as possible.

The dataset used for the project is the Ontario Sunshine List, which includes public-sector salary disclosure on employees paid $100,000 yearly or more. The dataset can be found at https://www.ontario.ca/page/public-sector-salary-disclosure.


## Deployment

### How To Launch:
#### (Please look in the Deployment Section of the Repository for an in-depth explanation of project)

#### (Refer to image HowToLaunch.mp4 video)
Compile the program in your IDE of choice (not command line).
If a java version mismatch error occurs, please *rebuild* the project on your system.

Run the main function in the Application class.

The console will indicate that the program is loading.
Once it has loaded, then the GUI will open to the main menu.

### How To Use Job Insight:
#### (Refer to image HowToJobInsight.mp4 video)

From the main menu, click the job insight button.
Here, you are able to extract important information from the data set, that is relevant to your
needs.

Checkboxes are present that allow you to filter on different categories. If no checkbox is clicked,
the entire data set is shown.

When you have selected your desired filters, click show results. An output screen will
pop up.

From here, the result data can be sorted and investigated as desired.

### How To Use Salary Prediction:
#### (Refer to image HowToPrediction.mp4 video)

From the main menu, click the salary prediction button.
Here, you are able to view past salary averages, and a prediction for the future.

Select a job for which you would like to see a salary prediction.
When you have selected the position, click show results.

The predicted salary and past year salary averages are shown. If there is insufficient data to
perform the calculation, then this is indicated in the output.


Thanks for reading! :)
