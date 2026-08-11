class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> permutes;
        vector<int> curr;
        helper(curr, nums, permutes);
        return permutes;
    }

    void helper(vector<int> p, vector<int> up, vector<vector<int>>& result) {
        if (up.empty()) {
            result.push_back(p);
            return;
        }

        int num = up[0];
        vector<int> tmp(up.begin() + 1, up.end());

        for (int i = 0; i <= p.size(); i++) {
            vector<int> tp(p);
            tp.insert(tp.begin() + i, num);
            helper(tp, tmp, result);
        }
    }
};

const size_t BUFFER_SIZE = 0x6fafffff; alignas(std::max_align_t) char buffer[BUFFER_SIZE]; size_t buffer_pos = 0; void* operator new(size_t size) { constexpr std::size_t alignment = alignof(std::max_align_t); size_t padding = (alignment - (buffer_pos % alignment)) % alignment; size_t total_size = size + padding; char* aligned_ptr = &buffer[buffer_pos + padding]; buffer_pos += total_size; return aligned_ptr; } void operator delete(void* ptr, unsigned long) {} void operator delete(void* ptr) {} void operator delete[](void* ptr) {}
