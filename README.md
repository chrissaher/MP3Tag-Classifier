# MP3Tag-Classifier
Classifier for MP3 files in 10 possible genres

This project was trying tto replicate what is shown in this paper:
http://cs229.stanford.edu/proj2012/DiabMaineroWatson-MusicalGenreTagClassificationWithCuratedAndCrowdsourcedDatasets.pdf

# How it works
This project got data from GTZAN (http://marsyasweb.appspot.com/download/data_sets/). From here, it got the following parameters per audio file per genre:
* Mel-Frequency Coefficients
* Zero Crossings
* Spectral Centroid
* Chroma Properties
* Spectral Rolloff

From it, tested 3 algorithms (Multiclass classifier, Naive Bayes and Logistic Regression). And got the following results:
<table>
<tr>
<td colspan="2">Multiclass Classifier</td>
</tr>
<tr>
<td>Correctly Classified Instances</td>
<td>33691 (10.0204%)</td>
</tr>
<tr>
<td>Incorrectly Classified Instances</td>
<td>302533 (89.9796%)</td>
</tr>
<tr>
<td>Precision</td>
<td>0.00</td>
</tr>
<tr>
<td>Recall</td>
<td>0.00</td>
</tr>
<tr>
<td>f1</td>
<td>0.00</td>
</tr>
<tr>
<td>Time elapsed</td>
<td>36 seconds</td>
</tr>
</table>
<table>
<tr>
<td colspan="2" >Naive Bayes</td>
</tr>
<tr>
<td>Correctly Classified Instances</td>
<td>156806 (46.6374%)</td>
</tr>
<tr>
<td>Incorrectly Classified Instances</td>
<td>179418 (53.3626%)</td>
</tr>
<tr>
<td>Precision</td>
<td>0.6695</td>
</tr>
<tr>
<td>Recall</td>
<td>0.8410</td>
</tr>
<tr>
<td>f1</td>
<td>0.7455</td>
</tr>
<tr>
<td>Time elapsed</td>
<td>2min 16sec</td>
</tr>
</table>
<table>
<tr>
<td colspan="2" >Logistic Regression</td>
</tr>
<tr>
<td>Correctly Classified Instances</td>
<td>217409 (64.662%)</td>
</tr>
<tr>
<td>Incorrectly Classified Instances</td>
<td>118815 (35.338%)</td>
</tr>
<tr>
<td>Precision</td>
<td>0.8331</td>
</tr>
<tr>
<td>Recall</td>
<td>0.9100</td>
</tr>
<tr>
<td>f1</td>
<td>0.8698</td>
</tr>
<tr>
<td>Time elapsed</td>
<td>1hour 48min</td>
</tr>
</table>

# Technologies Used
* Marsyas for getting parameters from audio files
* Python
* Weka - ML framework for java
* Java

# Notes
This project was made on 2013. Libraries might be deprecated
