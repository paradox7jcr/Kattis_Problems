#include <iostream>
#include <vector>
#include <string>
#include <cmath>

/*
using namespace std;

void printMatrix(vector< vector<char> > &mat, int m)
{
    for (int j = 0; j < m; j++) {
        for (int k = 0; k < m; k++)
        {
            cout << mat[j][k] << " ";
        }
        cout << endl;
    }
}

void convertToCode(vector< vector<char> > &mat, int m)
{
    for (int k = 0; k < m; k++) {
        for (int j = m-1; j >= 0 ; j--)
        {
            if(mat[j][k] == '*')
            {
                
            }
            else
            {
                cout << mat[j][k];
            }
        }
    }
    cout << endl;
}

int main()
{
    int n;
    string temp;
    getline(cin, temp);
    n = stoi(temp);
    for(auto i = 0; i < n; i++)
    {
        string original;
        getline(cin, original);
        int length = original.length();
        int m = 0;
        while (pow(m, 2) < length) { m++; }
        vector< vector<char> > matrix(m, vector<char> (m, '*'));
        int index = 0;
        
        for(int j = 0; j < m; j++){
            for(int k = 0; k < m; k++)
            {
                if(index < length)
                    matrix[j][k] = original[index];
                else
                {
                    j = m;
                    k = m;
                }
                index++;
            }
        }
        //printMatrix(matrix, m);
        convertToCode(matrix, m);
    }
    cin >> n;
    return 0;
}
*/