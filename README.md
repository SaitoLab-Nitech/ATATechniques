# ATATechniques

This is a test suite with anti-taint-analysis techniques discussed in our paper at [ARES 2021](https://www.ares-conference.eu/). Also, our journal paper has been published in August 2022, and we are preparing to open the new version of test suite used in the journal paper. **We will soon update this repository.**

When you reference this work, please cite our paper by one of the following:

- ARES 2021
    - Hiroki Inayoshi, Shohei Kakei, Eiji Takimoto, Koichi Mouri, and Shoichi Saito. 2021. VTDroid: Value-based Tracking for Overcoming Anti-Taint-Analysis Techniques in Android Apps. In The 16th International Conference on Availability, Reliability and Security (ARES 2021), August 17–20, 2021, Vienna, Austria. ACM, New York, NY, USA, 6 pages. https://doi.org/10.1145/3465481.3465759
- Journal paper
    - https://link.springer.com/article/10.1007/s10207-022-00603-9

## Setup

This is a project created with Android Studio. Please set up the latest version of Android Studio on your machine.

## Usage

1. Open this project with Android Studio
2. Set your IP address and port number into variables in MainActivity.java
    - Set IP address in hostIPAddr (default is "0.0.0.0")
    - Set port number in hostPort (default is 9000)
3. In MainActivity.java, choose one of ata techniques by uncommenting one of lines starting with ```srcUntainted = ```
    - By default, ```srcUntainted = testTechnique(srcTainted);``` is active
4. Execute it on an Android device by clicking "Run" on Android Studio
    - You should grant app the permission READ_PHONE_STATE for accessing IMEI
    - We have tested apps on Nexus 4 with TaintDroid (4.3r1) and Zenfone 4 (Android 8.0.0)

## References

- [AntiTaintDroid](https://github.com/gsbabil/AntiTaintDroid)
    - As our paper explains, our test suite is based on AntiTaintDroid, and most of the techniques here are combinations of techniques from AntiTaintDroid.
- [TaintDroid](https://github.com/TaintDroid)
