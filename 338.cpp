#include<iostream>
#include<vector>

using namespace std;

vector<int> countBits(int num)
{
    vector<int> v;
    if(num==0)
    {
        v.push_back(0);
        return v;
    }
    else if(num==1)
    {
        v.push_back(0);
        v.push_back(1);
        return v;
    }

    int i;
    for(i=0;i <= num;i++)
    {
        v.push_back(0);
    }
    v[0] = 0;
    v[1] = 1;
    for(i=2;i<=num;i++)
    {
        if(i % 2 == 0)
        {
            v[i] = v[i/2];
        }
        else
        {
            v[i] = 1 + v[i-1];
        }
    }
    return v;
}

int main()
{
    vector<int> v = countBits(1);
    auto it = v.begin();
    while(it != v.end())
    {
        cout<<*it<<"\t";
        it++;
    }
    return 0;
}
