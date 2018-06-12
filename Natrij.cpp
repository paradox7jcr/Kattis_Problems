#include <iostream>
#include <vector>
#include <string>

/*
using namespace std;

struct myTime
{
    int hour;
    int minute;
    int second;

    ~myTime(){}
    myTime()
    {
        hour = 0;
        minute = 0;
        second = 0;
    }

    myTime(int _hour, int _minute, int _second)
    {
        hour = _hour;
        minute = _minute;
        second = _second;
    }

    myTime(myTime &time1, myTime &time2)
    {
        if(time1.hour == time2.hour && time1.minute == time2.minute && time1.second == time2.second)
        {
            hour = 24;
            minute = 0;
            second = 0;
        }
        else
        {
            int deltaH = 0;
            int deltaM = 0;
            int deltaS = 0;
            if (time1.second <= time2.second)
            {
                deltaS = time2.second - time1.second;
            }
            else
            {
                deltaS = 60 - (time1.second - time2.second);
                deltaM = -1;
            }
            if (time1.minute <= time2.minute)
            {
                deltaM += time2.minute - time1.minute;
            }
            else
            {
                deltaM += 60 - (time1.minute - time2.minute);
                deltaH = -1;
            }
            if (deltaM == -1)
            {
                deltaM = 59;
                deltaH = -1;
            }
            if(time1.hour <= time2.hour)
            {
                deltaH += time2.hour - time1.hour;
            }
            else
            {
                deltaH += 24 - (time1.hour - time2.hour);
            }
            if(deltaH == -1)
            {
                deltaH = 23;
            }
            hour = deltaH;
            minute = deltaM;
            second = deltaS;
        }
    }
    void printHour()
    {
        if (hour >= 10) {
            cout << hour;
        }
        else {
            cout << "0" << hour;
        }
    }

    void printMinute()
    {
        if (minute >= 10) {
            cout << minute;
        }
        else {
            cout << "0" << minute;
        }
    }

    void printSecond()
    {
        if(second >=10) {
            cout << second; }
        else {
            cout << "0" << second; }
    }

    void PrintTime()
    {
        printHour();
        cout << ":";
        printMinute();
        cout << ":";
        printSecond();
        cout << endl;
    }
};

int main()
{
    string time1, time2;
    getline(cin, time1);
    getline(cin, time2);

    string answer;
    int hour1 = stoi(time1.substr(0, 2));
    int minute1 = stoi(time1.substr(3, 2));
    int second1 = stoi(time1.substr(6, 2));
    int hour2 = stoi(time2.substr(0, 2));
    int minute2 = stoi(time2.substr(3, 2));
    int second2 = stoi(time2.substr(6, 2));
    
    myTime start(hour1, minute1, second1);
    myTime end(hour2, minute2, second2);

    myTime difference(start, end);
    difference.PrintTime();
    cin >> time1;
}
/*
00:02:01
23:01:01
 */
