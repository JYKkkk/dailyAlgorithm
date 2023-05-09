//Main_boj_2293_coin1

import Foundation

var arr = readLine()!.split(separator: " ").map{Int($0)!}
var C = [Int](repeating: 0, count: arr[0])

for i in 0..<arr[0] {
    C[i] = Int(readLine()!)!
}

var dp = [Int](repeating: 0, count: arr[1]+1)
dp[0] = 1

for i in 0..<arr[0] {
    for j in stride(from: C[i], through: arr[1], by: 1) {
        dp[j] = dp[j]+dp[j-C[i]] < Int(pow(2.0, 31.0)) ? dp[j]+dp[j-C[i]] : 0
    }
}

print(dp[arr[1]])
