#include <bits/stdc++.h>

using namespace std;

#define int long long

#define fast() ios_base::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL)
#define endl '\n'

const int mod = 1e9 + 7;




void solve(){
	int n;
	cin >> n;
	vector<int> a(n), b(n);
	
	for(int &i: a) cin >> i;
	for(int &i: b) cin >> i;
	
	vector<pair<int, int>> vec;
	for(int i = 0; i < n; i++)
		vec.push_back({min(a[i], b[i]), max(a[i], b[i])});
	
	sort(vec.begin(), vec.end());
	
	multiset<int> ms;
	for(int i = 0; i < n; i++)
		ms.insert(vec[i].first);
	
	int res = *(ms.rbegin()) - *(ms.begin());
	//cout<<res<<endl;
	for(int i = 0; i < n; i++){
		ms.erase(vec[i].first);
		ms.insert(vec[i].second);
	
		res = min(res, *(ms.rbegin()) - *(ms.begin()));
	}
		//cout<<*(ms.rbegin()) - *(ms.begin())<<endl;
	
	cout << res << endl;
	
	
}

signed main() {
    fast();
	int t = 1;
	cin >> t;
	while(t--){
        solve();
    }
	return 0;
}






