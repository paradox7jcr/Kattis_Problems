#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

/*
using namespace std;
int main()
{
    string cards;
    getline(cin, cards);
    int numT = 0;
    int numC = 0;
    int numG = 0;
    for (int i = 0; i < cards.size(); i++)
    {
        switch (cards[i])
        {
        case 'T':
            numT++;
            break;
        case 'C':
            numC++;
            break;
        case 'G':
            numG++;
            break;
        default:
            break;
        }
    }
    int fewest = min(numT, numC);
    int realfewest = min(fewest, numG);
    double score = pow(numT, 2) + pow(numC, 2) + pow(numG, 2) + (7 * realfewest);
    cout << score;
    return 0;
}
*/