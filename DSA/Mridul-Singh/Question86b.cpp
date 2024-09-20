//LEETCODE PROBLEM -> 127

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) {
            return 0;
        }
        queue<pair<string, int>> q;
        q.push({beginWord, 1});
        unordered_set<string> visited;
        visited.insert(beginWord);
        while (!q.empty()) {
            auto [currentWord, currentLength] = q.front();
            q.pop();
            for (int i = 0; i < currentWord.length(); ++i) {
                string transformedWord = currentWord;
                for (char c = 'a'; c <= 'z'; ++c) {
                    transformedWord[i] = c;
                    if (transformedWord == endWord) {
                        return currentLength + 1;
                    }
                    if (wordSet.find(transformedWord) != wordSet.end() && visited.find(transformedWord)==visited.end()) {
                        q.push({transformedWord, currentLength + 1});
                        visited.insert(transformedWord);
                    }
                }
            }
        }
        return 0;
    }
};
