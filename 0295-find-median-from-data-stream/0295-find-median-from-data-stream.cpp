class MedianFinder {
public:
    multiset<int> mt1; 
    multiset<int> mt2; 

    MedianFinder() {}

    void addNum(int num) {
       
        if (mt1.empty() || num <= *mt1.rbegin()) {
            mt1.insert(num);
        } else {
            mt2.insert(num);
        }

        if (mt1.size() > mt2.size() + 1) {
            auto it = prev(mt1.end());
            mt2.insert(*it);
            mt1.erase(it);
        }
        else if (mt2.size() > mt1.size()) {
            auto it = mt2.begin();
            mt1.insert(*it);
            mt2.erase(it);
        }
    }

    double findMedian() {
        if (mt1.size() > mt2.size()) {
            return *mt1.rbegin();
        }

        return ((double)*mt1.rbegin() + *mt2.begin()) / 2.0;
    }
};